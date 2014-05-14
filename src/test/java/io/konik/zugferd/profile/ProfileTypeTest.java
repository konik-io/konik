package io.konik.zugferd.profile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ProfileTypeTest {


   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void getProfile_Basic() throws Exception {
      ProfileType.getProfile("urn:ferd:invoice:rc:basic");
   }

   @Test
   public void getProfileByName_Basic() throws Exception {
      ProfileType.getProfileByName("basic");
   }
   
   @Test
   public void hasThreeEntries() throws Exception {
      ProfileType[] enumConstants = ProfileType.class.getEnumConstants();
      assertThat(enumConstants).hasSize(3);
   }
   
   

}
