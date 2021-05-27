package utils;

public class UuidMain {

	public static void main(String[] args) {
		utils.UUIDGenerator obj = new utils.UUIDGenerator();
		String id = obj.uuid();
		System.out.println(id);

	}

}