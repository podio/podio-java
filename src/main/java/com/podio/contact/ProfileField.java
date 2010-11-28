package com.podio.contact;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.joda.time.LocalDate;

import com.podio.serialize.DateTimeUtil;

public abstract class ProfileField<F, R> {

	private static final Map<String, ProfileField<?, ?>> MAP = new HashMap<String, ProfileField<?, ?>>();

	/**
	 * The full name
	 */
	public static final ProfileField<String, String> NAME = new StringProfileField(
			"name", true);

	/**
	 * The file id of the avatar
	 */
	public static final ProfileField<Integer, Integer> AVATAR = new IntegerProfileField(
			"avatar", true);

	/**
	 * The birthdate
	 */
	public static final ProfileField<LocalDate, String> BIRTHDATE = new DateProfileField(
			"birthdate", true);

	/**
	 * The organization or company the person is associated with
	 */
	public static final ProfileField<String, String> ORGANIZATION = new StringProfileField(
			"organization", true);

	/**
	 * The username for Skype
	 */
	public static final ProfileField<String, String> SKYPE = new StringProfileField(
			"skype", true);

	/**
	 * Short text about the person
	 */
	public static final ProfileField<String, String> ABOUT = new StringProfileField(
			"about", true);

	/**
	 * Email address
	 */
	public static final ProfileField<String, String> MAIL = new StringProfileField(
			"mail", false);

	/**
	 * The address where the person lives or work
	 */
	public static final ProfileField<String, String> ADDRESS = new StringProfileField(
			"address", false);

	/**
	 * Any instant messaging address
	 */
	public static final ProfileField<String, String> IM = new StringProfileField(
			"im", false);

	/**
	 * The location of the person
	 */
	public static final ProfileField<String, String> LOCATION = new StringProfileField(
			"location", false);

	/**
	 * The phone number
	 */
	public static final ProfileField<String, String> PHONE = new StringProfileField(
			"phone", false);

	/**
	 * The persons title, usually the work title
	 */
	public static final ProfileField<String, String> TITLE = new StringProfileField(
			"title", false);

	/**
	 * An URL to the persons homepage or the homepage of the company
	 */
	public static final ProfileField<String, String> URL = new StringProfileField(
			"url", false);

	private final String name;

	private final boolean single;

	public ProfileField(String name, boolean single) {
		super();
		this.name = name;
		this.single = single;

		MAP.put(name, this);
	}

	@JsonValue
	public String getName() {
		return name;
	}

	public boolean isSingle() {
		return single;
	}

	@Override
	public String toString() {
		return getName();
	}

	public abstract F parse(R object);

	public abstract R format(F object);

	private static class StringProfileField extends
			ProfileField<String, String> {

		public StringProfileField(String name, boolean single) {
			super(name, single);
		}

		@Override
		public String parse(String object) {
			return object;
		}

		@Override
		public String format(String object) {
			return object;
		}
	}

	private static class IntegerProfileField extends
			ProfileField<Integer, Integer> {

		public IntegerProfileField(String name, boolean single) {
			super(name, single);
		}

		@Override
		public Integer parse(Integer object) {
			return object;
		}

		@Override
		public Integer format(Integer object) {
			return object;
		}
	}

	private static class DateProfileField extends
			ProfileField<LocalDate, String> {

		public DateProfileField(String name, boolean single) {
			super(name, single);
		}

		@Override
		public LocalDate parse(String object) {
			return DateTimeUtil.parseDate(object);
		}

		@Override
		public String format(LocalDate object) {
			return DateTimeUtil.formatDate(object);
		}
	}

	@JsonCreator
	public static ProfileField<?, ?> getByName(String value) {
		return MAP.get(value);
	}
}
