public class RandomNames {
	
	public static void main(String[] args) {
		String sourceString = "";
		int nameSize = 5;
		int namesCount = 20;
		if(args.length == 0){
			System.out.println("--------------USAGE----------------");
			System.out.println("Use 'NameSize' argument to set character count of name, like 'NameSize10'");
			System.out.println("");
			System.out.println("Use 'NamesCount' argument to set the number of names to generate, like 'NamesCount10'");
			System.out.println("");
			System.out.println("The name generator will generate names based on tags, so you need to feed the algorithm with some");
			System.out.println("tags, to do so just write the tags as arguments, like 'java RandomNames NameSize5 NamesCount10 house car bike'");
			System.out.println("-----------------------------------");
		} else{
			for(int i = 0; i < args.length; i++){
				String arg = args[i];
				if(arg.contains("NameSize")){
					nameSize = Integer.parseInt(arg.replaceAll("NameSize", ""));
				}else if (arg.contains("NamesCount")){
					namesCount = Integer.parseInt(arg.replaceAll("NamesCount", ""));
				}else{
					sourceString += arg;
				}
			}
			char[] source = sourceString.toCharArray();
			nameSize = nameSize < source.length ? nameSize : source.length;
			System.out.println("--------------INPUT----------------");
			System.out.println("Source:\t\t" + sourceString);
			System.out.println("NameSize:\t" + nameSize);
			System.out.println("NamesCount:\t" + namesCount);
			System.out.println("--------------NAMES----------------");
			for(int i = 0; i < namesCount; i++){
				String result = "";
				boolean wasConsonant = false;
				boolean consonant = true;
				for(int j = 0; j < nameSize; j++){
					char c = source[(int)Math.round((Math.random() * (source.length - 1)))];
					consonant = isConsonant(c);
					while((!consonant && !wasConsonant)){
						c = source[(int)Math.round((Math.random() * (source.length - 1)))];
						consonant = isConsonant(c);
					}
					result += c;
					wasConsonant = consonant;
				}
				System.out.println(result);
			}
			System.out.println("--------By John's Project----------");
		}
	}
	
	public static boolean isConsonant(char c){
		return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
	}
}
