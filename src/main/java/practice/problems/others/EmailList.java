package practice.problems.others;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;

/**
 * Groups email ids for email list providers.
 *
 * @author Yashraj R. Sontakke
 */
public class EmailList {

    /**
     * Groups emails by email list providers.
     *
     * @param emailList the {@link ImmutableList} of email ids.
     */
    public void grouping(final ImmutableList<String> emailList) {
        ImmutableMultimap.Builder<String, String> builder = ImmutableMultimap.builder();

        for (final String email : emailList) {
            if (email.contains("@")) {
                String[] split = email.split("@");
                builder.put(split[1], split[0]);
            }
        }

        ImmutableMultimap<String, String> emailsByProvider = builder.build();
        for (String provider : emailsByProvider.keySet()) {
            System.out.println(String.format("%s %s",provider,emailsByProvider.get(provider.toString())));
        }
    }

    public static void main(String[] args) {
        final EmailList emailList = new EmailList();
        final ImmutableList<String> emails = ImmutableList.of("yash@yahoo.com", "yash1@yahoo.com", "yash2@yahoo.com",
                "yash3@yahoo.com", "yash4@yahoo.com", "yash5@gmail.com", "yash6@gmail.com", "yash7@gmail.com",
                "yash8@hotmail.com");
        emailList.grouping(emails);
    }

}
