package pa0;

public class Usage {

    private int count;
    private String username;


    public Usage( String username, int count )
    {
        this.username=username;
        this.count=count;

    }



    public int getCount()
    {
        return this.count;
    }

    public String getUser() {
        return this.username;
    }

    public void increment()
    {
        count++;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "count=" + count +
                ", username='" + username + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Usage test= new Usage("Eriksson",1); // create a object type Usage
        Usage test1= new Usage("pat",2);
        System.out.println(" Username = "+ test.getUser());
        System.out.println(" Count = "+ test.getCount());
        System.out.println(" Username = "+ test1.getUser());
        System.out.println(" Count = "+ test1.getCount());

    }


}
