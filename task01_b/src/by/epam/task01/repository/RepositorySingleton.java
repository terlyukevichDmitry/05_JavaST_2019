package by.epam.task01.repository;

import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.recorder.Observer;
import by.epam.task01.recorder.Recorder;
import by.epam.task01.repository.specification.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * In this class we use for different methods with Repository Method.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class RepositorySingleton implements Observer {
    /**
     * For create only one object.
     */
    private static RepositorySingleton instance;
    /**
     * For consists different pyramid in Collection.
     */
    private List<Pyramid> pyramidList;
    /**
     * For consists different Recorder in Collection.
     */
    private List<Recorder> recorderList;
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(RepositorySingleton.class);
    /**
     * Constructor for initialization collections.
     */
    public RepositorySingleton() {
        pyramidList = new ArrayList<>();
        recorderList = new ArrayList<>();
    }

    /**
     * set data.
     * @param pyramidListP for set data.
     */
    public void setPyramidList(final List<Pyramid> pyramidListP) {
        this.pyramidList = pyramidListP;
    }
    /**
     * set data.
     * @param recorderListP for set data.
     */
    public void setRecorderList(final List<Recorder> recorderListP) {
        this.recorderList = recorderListP;
    }

    /**
     * Constructor with parameters.
     * @param pyramidListP for initialization list with Pyramid objects.
     * @param recorderListP for initialization list with Recorder objects.
     */
    public RepositorySingleton(final List<Pyramid> pyramidListP,
                               final List<Recorder> recorderListP) {
        this.pyramidList = pyramidListP;
        this.recorderList = recorderListP;
    }

    /**
     * Metod for create object or return already existing object.
     * @return instance.
     */
    public static RepositorySingleton getInstance() {
        if (instance == null) {
            instance = new RepositorySingleton();
        }
        return instance;
    }

    /**
     * Get collection with Pyramid objects.
     * @return pyramidList
     */
    public List<Pyramid> getPyramidList() {
        return pyramidList;
    }
    /**
     * Get collection with Pyramid objects.
     * @return recorderList
     */
    public List<Recorder> getRecorderList() {
        return recorderList;
    }
    /**
     * This method we use for add new object.
     * @param pyramid for add this in Collection.
     * @throws NullDataException for check on NullPointerException
     */
    public void addObject(final Pyramid pyramid) throws NullDataException {
        if (pyramid == null) {
            LOGGER.error("We have null in object!");
            throw new NullDataException("We have null in object!");
        }
        pyramidList.add(pyramid);
        Recorder recorder = new Recorder();
        recorder.createSlotForNewPyramid(pyramid);
        pyramid.addObserver(recorder);
        recorderList.add(recorder);
    }
    /**
     * This method we use for remove object in Collection.
     * @throws NullDataException for check mistake.
     * @param pyramid for remove.
     */
    public void removeObject(final Pyramid pyramid) throws NullDataException {

        if (pyramid == null) {
            LOGGER.error("We have null in object!");
            throw new NullDataException("We have null in object!");
        }
        int counter = 0;
        for (Pyramid element : pyramidList) {
            if (element == pyramid) {
                pyramidList.remove(pyramid);
                pyramid.removeObserver(recorderList.get(counter));
                recorderList.remove(counter);

            }
            counter++;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "RepositorySingleton{" + "pyramidList=" + pyramidList
                + ", recorderList=" + recorderList + '}';
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Pyramid truePyramid) {
        Pyramid pyramid = truePyramid;
        int counter = 0;
        for (Pyramid element: pyramidList) {
            if (pyramid.equals(element)) {
               pyramidList.set(counter, truePyramid);
               recorderList.get(counter).update(truePyramid);
            }
            counter++;
        }
    }

    /**
     * For create query for decide different methods.
     * @param specification for check class.
     * @param index .
     * @return list with true pyramid objects.
     */
    public List<Pyramid> query(final PyramidSpecification specification,
                               final int index) {
        List<Pyramid> pyramids = null;
        if (specification instanceof FindPyramidSpecification) {
                pyramids = new ArrayList<>();
                for (Pyramid pyramid : getPyramidList()) {
                    if (((FindPyramidSpecification) specification).specified(
                            pyramid, index)) {
                        pyramids.add((pyramid));
                    }
                }
        } else if (specification instanceof FindRecorderSpecification) {
            pyramids = new ArrayList<>();
            int counter = 0;
            for (Recorder recorder : getRecorderList()) {
                if (((FindRecorderSpecification) specification).specified(
                        recorder)) {
                    pyramids.add(getPyramidList().get(counter));
                }
                counter++;
            }
        } else if (specification instanceof SortPyramidSpecification) {
            ((SortPyramidSpecification) specification).sort(pyramidList);
            pyramids = pyramidList;
        } else if (specification instanceof SortRecorderSpecification) {
            ((SortRecorderSpecification) specification).sort(recorderList);
            List<Pyramid> pyramids1 = new ArrayList<>();
            for (Recorder r : recorderList) {
                for (Pyramid p : pyramidList) {
                    if (r.getId() == (p.getId())) {
                        pyramids1.add(p);
                    }
                }
            }
            pyramids = pyramids1;
        } else {
            LOGGER.info("We don't have the right specification");
        }
        return pyramids;
    }
}
