package Exemple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesAndPaths {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// C:\Users\sabousai\eclipse-workspace\CollectionsVsStreams\resources
		
		List<String> stringList = Files.lines(Paths.get("C:\\Users\\sabousai\\eclipse-workspace\\CollectionsVsStreams\\resources\\web.xml"))
				.filter(line -> line.contains("display-name"))
				.map(line -> line
							.trim()
							.replaceAll("display-name", "")
							.replace("<", "")
							.replace(">", "")
							.replace("/", ""))
				.collect(Collectors.toList());
		System.out.println(stringList.get(0));
	}

}
