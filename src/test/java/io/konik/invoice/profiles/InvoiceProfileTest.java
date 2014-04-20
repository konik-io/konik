package io.konik.invoice.profiles;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

public class InvoiceProfileTest {


   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void getProfile_Basic() throws Exception {
      InvoiceProfile.getProfile("urn:ferd:invoice:rc:basic");
   }

   @Test
   public void getProfileByName_Basic() throws Exception {
      InvoiceProfile.getProfileByName("basic");
   }
   
   @Test
   public void hasThreeEntries() throws Exception {
      InvoiceProfile[] enumConstants = InvoiceProfile.class.getEnumConstants();
      assertThat(enumConstants).hasSize(3);
   }
   
   

}
