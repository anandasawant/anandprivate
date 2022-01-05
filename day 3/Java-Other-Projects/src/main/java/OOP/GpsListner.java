package OOP;

public interface GpsListner {

    float [] locate ();

    //java 8 says ,interface can have default method
    default boolean checkLocation(){
        return locate().length==2;
    }
}
