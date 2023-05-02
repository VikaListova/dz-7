class Main {
	public static void main(String[] args) {
		var planet = SolarSystemPlanet.MARS.getDistanceFromPrevious();
		System.out.println(planet);
	}
}

enum SolarSystemPlanet {

	MERCURY(1, 0, 0, 23.2F, null, null),
	VENUS(2, 1000, 2000, 6051.8F, MERCURY, null),
	EARTH(3, 3000, 4000, 6371.0F, VENUS, null),
	MARS(4, 5000, 6000, 3389.5F, EARTH, null),
	JUPITER(5, 7000, 8000, 69911.0F, MARS, null),
	SATURN(6, 9000, 10000, 58232.0F, JUPITER, null),
	URANUS(7, 11000, 12000, 25362.0F, SATURN, null),

	NEPTUNE(8, 14000, 16000, 24622.0F, URANUS, null);
	private int orderFromSun;
	private long distanceFromPrevious;
	private long distanceFromSun;
	private float radius;
	private final SolarSystemPlanet previousPlanet;
	private SolarSystemPlanet nextPlanet;

	private SolarSystemPlanet(
			int orderFromSun,
			long distanceFromPrevious,
			long distanceFromSun,
			float radius,
			SolarSystemPlanet previousPlanet,
			SolarSystemPlanet nextPlanet) {

		this.orderFromSun = orderFromSun;
		this.distanceFromPrevious = distanceFromPrevious;
		this.distanceFromSun = distanceFromSun;
		this.radius = radius;
		this.previousPlanet = previousPlanet;
		this.nextPlanet = nextPlanet;
	}

	/**
	 * Блок static необходим для присвоения полю nextPlanet соответствующего значения
	 * после того, как все перечисления enum были созданы
	 * в противном случае будет ошибка из-за того, что полю nextPlanet пытаешься присвоить
	 * еще не созданное значение
	 */

	static {
		for (SolarSystemPlanet planet : SolarSystemPlanet.values()) {
			if (planet.orderFromSun != SolarSystemPlanet.values().length) {
				planet.nextPlanet = SolarSystemPlanet.values()[planet.orderFromSun];
			}
		}
	}


	public int getOrderFromSun() {
		return orderFromSun;
	}

	public long getDistanceFromPrevious() {
		return distanceFromPrevious;
	}

	public long getDistanceFromSun() {
		return distanceFromSun;
	}

	public float getRadius() {
		return radius;
	}

	public SolarSystemPlanet getPreviousPlanet() {
		return previousPlanet;
	}

	public SolarSystemPlanet getNextPlanet() {
		return nextPlanet;
	}
}
