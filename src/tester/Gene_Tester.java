package tester;
import model.Gene;

public class Gene_Tester {
	public static void main(String[] args){
		Gene g = new Gene("Simmons");		
		System.out.println("Name:" + g.getName());
		
		System.out.println("---NEW GENE---");
		Gene g2 = new Gene("A-Gene", "Heterozygous", "rNJx01", "HE", "Red");		
		System.out.println(g2.toString());
		
		g2.setType("wild");
		
		System.out.println("---SECOND GENE CHANGE---");
		System.out.println(g2.toString());
		
	}
}