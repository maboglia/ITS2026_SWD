package stringhe;

public class ProvaStringhe {
	
	public static void main(String[] args) {
		
		String s1 = "ciao";
		String s2 = "ciao mondo";
		
		
		s1 += " mondo";
		
		System.out.println(s1== s2);
		System.out.println(s1.equals(s2));
		
		String[] frutti = {"mela", "pera", "fragola", "banana"};
		
		StringBuilder output = new StringBuilder();
		
		output.append( "<ul>\n");
		
		for (String frutto : frutti) {
			output.append("<li>" + frutto+"</li>\n");
		}
		
		output.append("</ul>\n");
		
		System.out.println(output.toString());
		
		
	}
	

}
