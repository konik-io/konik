package io.konik.zugferd.profile;

import static io.konik.zugferd.profile.ProfileVersion.RC;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ProfileVersionTest {

   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void latestVersion() throws Exception {
      ProfileVersion latestVersion = ProfileVersion.latestVersion();
      assertThat(latestVersion).isEqualTo(ProfileVersion.V1P0);
   }

   @Test
   public void parse_rc() throws Exception {
      ProfileVersion profileVersion = ProfileVersion.parse("rc");
      assertThat(profileVersion).isEqualTo(ProfileVersion.RC);
   }

   @Test
   public void parse_rce() throws Exception {
      ProfileVersion profileVersion = ProfileVersion.parse("rce");
      assertThat(profileVersion).isEqualTo(ProfileVersion.RCE);
   }

   @Test
   public void parse_1p0() throws Exception {
      ProfileVersion profileVersion = ProfileVersion.parse("1p0");
      assertThat(profileVersion).isEqualTo(ProfileVersion.V1P0);
   }

   @Test
   public void extractVersion_rc() throws Exception {
      ProfileVersion version = ProfileVersion.extractVersion("urn:ferd:invoice:rc:comfort");
      assertThat(version).isEqualTo(RC);
   }

   @Test
   public void extractVersion_1p0() throws Exception {
      ProfileVersion version = ProfileVersion.extractVersion("urn:ferd:CrossIndustryDocument:invoice:1p0:comfort");
      assertThat(version).isEqualTo(ProfileVersion.V1P0);
   }

   @Test
   public void toStringTest() throws Exception {
      assertThat(ProfileVersion.RC.toString()).isEqualTo("rc");
   }

}
