package persistence;

public class ManejoArchivos {

   private static ManejoArchivos instance;
   
   private ManejoArchivos(){
       
   }
   
   public static ManejoArchivos getInstance(){
       if(instance == null){
           instance = new ManejoArchivos();
       }
       return instance;
   }

}
