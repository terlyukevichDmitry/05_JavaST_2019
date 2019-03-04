package first;

class Store {
    int counter = 0;
    final int N = 3;
    synchronized int put() {
        if(counter < N)
        {
            counter++; // кладем товар
            System.out.println("Производитель добавил один товар");
            System.out.println ("склад имеет"+ counter + "товар(ов)");
            notifyAll();
            return 1; // в случае удачного выполнения возвращаем 1
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;// в случае неудачного выполнения возвращаем 0
    }
    // метод для покупателей
    synchronized int get() {
        if(counter > 0) //если хоть один товар присутствует
        {
            counter--; //берем товар
            System.out.println("Производитель купил один товар");
            System.out.println ("склад имеет" + counter + "товар(ов)");
            notifyAll();
            return 1;// в случае удачного выполнения возвращаем 1
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;// в случае неудачного выполнения возвращаем 0
        }
    }
}

