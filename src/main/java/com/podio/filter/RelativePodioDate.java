package com.podio.filter;

public class RelativePodioDate implements PodioDate {
	
	public static enum Unit {
		DAY('d'),
		WEEK('w'),
		MONTH('m'),
		YEAR('y');
		
		private final char character;
		
		private Unit(char character) {
			this.character = character;
		}

		public char getCharacter() {
			return character;
		}
	}
	
	private final int offset;
	
	private final Unit unit;
	
	private final boolean round;

	public RelativePodioDate(int offset, Unit unit, boolean round) {
		super();
		this.offset = offset;
		this.unit = unit;
		this.round = round;
	}

	public int getOffset() {
		return offset;
	}

	public Unit getUnit() {
		return unit;
	}

	public boolean isRound() {
		return round;
	}

	@Override
	public String serialize() {
		String result = Integer.toString(this.offset);
		result += this.unit.getCharacter();
		if (this.round) {
			result += "r";
		}
		return result;
	}

}
