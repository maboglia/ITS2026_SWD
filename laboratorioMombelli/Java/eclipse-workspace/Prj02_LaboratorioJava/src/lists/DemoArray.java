package lists;

public class DemoArray {

	public static void main(String[] args) {
		// unico caso in cui uso le quadre e non le tonde
		int[] marks = new int[10];
		int distance = marks.length;
		int examsApply = 0;
		int total = 0;
		
		try {
		
			//System.out.println(5/0);
			marks [0] = 25;
			marks [1] = 27;
			marks [3] = 29;
			marks [4] = 28;
			marks [6] = 26;
		
			for (int i = 0; i <= distance; i++) {
				System.out.println(marks[i]);
				if (marks[i]> 0)
					examsApply++;
				total += marks[i];
			}
		
			System.out.println("Totale: " + total);
			System.out.println("Media: " +(double)total / examsApply);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Eccezione accesso all'array");
			System.err.println(e.getMessage());
		}
		catch (ArithmeticException e) {
			System.err.println("Eccezione aritmetica!");
			System.err.println(e.getMessage());
		}
		catch(Exception e) {
				System.err.println("ECCEZIONALE VERAMENTE!");
				System.err.println(e.getMessage());
			}
		}
	}


