package io.konik.zugferd.profile;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
