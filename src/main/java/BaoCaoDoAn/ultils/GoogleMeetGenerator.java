package BaoCaoDoAn.ultils;

import org.springframework.stereotype.Component;

@Component
public class GoogleMeetGenerator {
	final static String PATERN_LINK = " https://meet.google.com/lookup/";
	final int sizeOfString = 15;
	private static RandomString randomString;

	public GoogleMeetGenerator() {
		// TODO Auto-generated constructor stub
	}

	public RandomString getRandomString() {
		if (randomString == null) {
			randomString = new RandomString(sizeOfString);

		}
		return randomString;
	}

	public String getLinkMeet() {
		String meetLink = getRandomString().nextString();
		meetLink = PATERN_LINK + meetLink;
		return meetLink;
	}
}
