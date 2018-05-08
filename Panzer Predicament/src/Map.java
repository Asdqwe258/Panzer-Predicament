public class Map {
	private static int[][][] MAP_DATA;

	public Map(int x, int y) {
		MAP_DATA = new int[x][y][2];
		for(int k = 0; k < MAP_DATA.length; k++){
			for(int i = 0; i < MAP_DATA[0].length; i++){
				for(int z = 0; z < MAP_DATA[0][0].length; z++){
					if(Math.random() < .5){
						generateBarrier(k,i,z);
					}
				}
			}
		}
	}

	private static void generateBarrier(int x, int y,int z){
		MAP_DATA[x][y][z] = 1;
	}
	
	public int[][][] getMapData(){
		return MAP_DATA;
	}
	public int getBarrier(int x, int y, int z){
		return MAP_DATA[x][y][z];
	}
}
