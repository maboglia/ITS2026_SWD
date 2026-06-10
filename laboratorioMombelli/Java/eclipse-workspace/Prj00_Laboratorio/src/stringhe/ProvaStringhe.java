package stringhe;

public class ProvaStringhe {

	public static void main(String[] args) {
		
		String s1 = "ciao";
		String s2 = new String("ciao");

		System.out.println(s1.equals(s2));
		
		s1 += " mondo";
		
		System.out.println(s1);
		System.out.println(s1 == s2); // mai usare con gli oggetti
		System.out.println(s1.equals(s2));
		
		String[] frutti = new String[4];
		String[] frutti2 ={"mela", "pera", "fragola", "banana"};
		
		StringBuilder output = new StringBuilder();
		
		//String output = "";
		output.append("<ul>\n");
		
		//output += "<ul>";
		
		for (String frutto : frutti2) {
			//output += "<li>" + frutto + "</li>\n";
			output.append("<li>" + frutto + "</li>\n");
		}
		
		
		//output += "</ul>";
		output.append("</ul>\n");
		
		System.out.println(output);
	}
	

}
