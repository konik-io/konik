package io.konik;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileOutputStream;

import org.assertj.core.util.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unitils.thirdparty.org.apache.commons.io.IOUtils;

@SuppressWarnings({ "javadoc", "static-method" })
public class ConfigurationTest {

   private static final String CONFIG_FILE = "target/test-classes/io.konik.configuration.properties";

   @Before
   public void setUp() throws Exception {
   }

   @After
   public void resetToDefault() {
      System.setProperty("io.konik.stripTrailingZeros", "true");
      Configuration.INSTANCE.reload();
      Files.delete(new File(CONFIG_FILE));
   }

   @Test
   public final void getProperty_fromFile() throws Exception {
      IOUtils.write("io.konik.key=value", new FileOutputStream(CONFIG_FILE));
      Configuration.INSTANCE.reload();
      assertThat(Configuration.INSTANCE.getProperty("io.konik.key")).isEqualTo("value");
   }

   @Test
   public final void getPropertyDefault() throws Exception {
      assertThat(Configuration.INSTANCE.getProperty("key", "value")).isEqualTo("value");
   }

   @Test
   public final void stripTrailingZeros_defaultIsTrue() throws Exception {
      assertThat(Configuration.INSTANCE.stripTrailingZeros()).isTrue();
   }

   @Test
   public final void stripTrailingZeros_SystemProperty() throws Exception {
      System.setProperty("io.konik.stripTrailingZeros", "false");
      Configuration.INSTANCE.reload();
      assertThat(Configuration.INSTANCE.stripTrailingZeros()).isFalse();
   }

   @Test
   public final void sgetProperty_SystemPropertyOverrideFile() throws Exception {
      IOUtils.write("io.konik.OverrideFile=value", new FileOutputStream(CONFIG_FILE));
      System.setProperty("io.konik.OverrideFile", "is overridden");
      Configuration.INSTANCE.reload();
      assertThat(Configuration.INSTANCE.getProperty("io.konik.OverrideFile")).isEqualTo("is overridden");
      resetToDefault();
   }

   @Test
   public final void toStringResult() throws Exception {
      String result = Configuration.INSTANCE.toString();
      assertThat(result).isNotEmpty();
   }

}
