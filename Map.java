//Kevin, Chris, Andrew
//6-12-18
//Period 5
public class Map {
	private static boolean[][][] MAP_DATA;//x, y, 0=vertical 1=horizontal
	private static int PLAYER_1_SPAWNX;
	private static int PLAYER_1_SPAWNY;
	private static int PLAYER_2_SPAWNX;
	private static int PLAYER_2_SPAWNY;

	public Map(int x, int y) {
		MAP_DATA = new boolean[x][y][2];
	}

	public static void generateBarrier(int x, int y, int z) {
		MAP_DATA[x][y][z] = true;
	}

	public boolean[][][] getMapData() {
		return MAP_DATA;
	}

	public boolean getBarrier(int x, int y, int z) {
		return MAP_DATA[x][y][z];
	}

	public static void generateRandomMap() {	// unused code
		for (int k = 0; k < MAP_DATA.length; k++) {
			for (int i = 0; i < MAP_DATA[0].length; i++) {
				for (int z = 0; z < MAP_DATA[0][0].length; z++) {
					if (Math.random() < .5) {
						generateBarrier(k, i, z);
					}
				}
			}
		}
	}
	
	public static boolean generateSpawn(int[][][] map){
		return false;
	}
	public static boolean placeSpawn1(int x, int y){
	PLAYER_1_SPAWNX = x;
	PLAYER_1_SPAWNY = y;
	return true;
	}
	
	public static boolean placeSpawn2(int x, int y){
	PLAYER_2_SPAWNX = x;
	PLAYER_2_SPAWNY = y;
	return true;
	}
	
	
	
	
	
	
}
