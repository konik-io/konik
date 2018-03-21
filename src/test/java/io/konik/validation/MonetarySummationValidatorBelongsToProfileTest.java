package io.konik.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.groups.Default;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;

@RunWith(Parameterized.class)
public class MonetarySummationValidatorBelongsToProfileTest {

	private static final List<Class> BASIC = Arrays.asList(new Class[]{Default.class});
	private static final List<Class> COMFORT = Arrays.asList(new Class[]{Default.class, Comfort.class});
	private static final List<Class> EXTENDED = Arrays.asList(new Class[]{Default.class, Comfort.class, Extended.class});

	@Parameters(name = "Check if method {1} of class {0} belongs to {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{ A.class, "getName", BASIC, 	false},
				{ A.class, "getName", COMFORT, 	true},
				{ A.class, "getName", EXTENDED,	true},
				{ B.class, "getName", BASIC, 	false},
				{ B.class, "getName", COMFORT,	false},
				{ B.class, "getName", EXTENDED,	true},
				{ C.class, "getName", BASIC,	true},
				{ C.class, "getName", COMFORT,	true},
				{ C.class, "getName", EXTENDED,	true},
				{ D.class, "getName", BASIC,	true},
				{ D.class, "getName", COMFORT,	true},
				{ D.class, "getName", EXTENDED,	true}
		});
	}

	@Parameter
	public Class<?> clazz;

	@Parameter(1)
	public String methodName;

	@Parameter(2)
	public List<Class<?>> validationGroups;

	@Parameter(3)
	public boolean expectedResult;

	@Test
	public void runParameterizedTest() {
		//when:
		boolean result = MonetarySummationValidator.belongsToProfile(clazz, methodName, validationGroups);

		//then:
		assertThat(result).isEqualTo(expectedResult);

	}

	public static class A {
		private String name;

		@Comfort
		public String getName() {
			return name;
		}
	}

	public static class B {
		private String name;

		@Extended
		public String getName() {
			return name;
		}
	}

	public static class C {
		private String name;

		@Basic
		public String getName() {
			return name;
		}
	}

	public static class D {
		private String name;

		public String getName() {
			return name;
		}
	}
}