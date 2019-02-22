package by.epam.task01.repository;

import by.epam.task01.entity.Pyramid;
import by.epam.task01.recorder.Observer;
import by.epam.task01.recorder.Recorder;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class RepositorySingleton implements Observer {
    private static RepositorySingleton instance;
    private List<Pyramid> pyramidList;
    private List<Recorder> recorderList;

    private RepositorySingleton() {
        pyramidList = new ArrayList<>();
        recorderList = new ArrayList<>();
    }

    public static RepositorySingleton getInstance() {
        if (instance == null) {
            instance = new RepositorySingleton();
        }
        return instance;
    }

    public List<Pyramid> getPyramidList() {
        return pyramidList;
    }

    public List<Recorder> getRecorderList() {
        return recorderList;
    }

    public static void setInstance(RepositorySingleton instance) {
        RepositorySingleton.instance = instance;
    }

    public void setPyramidList(List<Pyramid> pyramidList) {
        this.pyramidList = pyramidList;
    }

    public void setRecorderList(List<Recorder> recorderList) {
        this.recorderList = recorderList;
    }

    public void save(final Pyramid pyramid) {
        pyramidList.add(pyramid);
        Recorder recorder = new Recorder();
        recorder.register(pyramid);
        recorderList.add(recorder);
    }

    @Override
    public String toString() {
        return "RepositorySingleton{" +
                "pyramidList=" + pyramidList +
                ", recorderList=" + recorderList +
                '}';
    }

    @Override
    public void update(Object object) {
        Pyramid pyramid = (Pyramid)object;
        int counter = 0;
        for (Pyramid element: pyramidList) {
            if (pyramid == element) {
               pyramidList.set(counter, pyramid);
               recorderList.get(counter++).update(object);
            }
        }
    }
}
