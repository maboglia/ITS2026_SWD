public class LibraryDemo {

    public static void main(String[]args){

        Library library = new Library();

        for(Book l: library.getBooks()){
            if(l.author.equals("Victor Hugo")){
                 System.out.println(l);
            }
            
        }
    }
}
