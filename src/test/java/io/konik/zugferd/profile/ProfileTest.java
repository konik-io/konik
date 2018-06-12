package io.konik.zugferd.profile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void profile() {
      String fullName = new Profile(ConformanceLevel.BASIC).fullName();
      assertThat(fullName).contains("urn:ferd:CrossIndustryDocument:invoice:1p0:basic");
   }
}
