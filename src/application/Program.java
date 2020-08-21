package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = scan.nextInt();
		scan.nextLine();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char answer = scan.next().charAt(0);
			scan.nextLine();
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Price: ");
			double price = scan.nextDouble();
			scan.nextLine();
			
			if(answer == 'c') {
				list.add(new Product(name, price));
			}else if(answer == 'u') {
				System.out.print("Manufacture date: ");
				Date manufactureDate = sdf.parse(scan.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}else if(answer == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = scan.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
		
		scan.close();
	}

}
