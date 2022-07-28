public class PersonIntroduction{
    public static void main(String args[]){
        String name = args[0];
        Person person = new Person(name);
        person.introduce();
    }
}