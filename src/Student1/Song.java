package Student1;
import java.io.*;
import java.util.*;
public class Song< I, Y, T, N> {
	private I songData1;
	private Y songData2;
	private T songData3;
	private N songData4;
	static File reader = new File("C:\\Users\\hhirp\\eclipse-workspace\\SongList.txt");
	

	public Song(I songData1, Y songData2, T songData3, N songData4) {
		this.songData1 = songData1;
		this.songData2 = songData2;
		this.songData3 = songData3;
		this.songData4 = songData4;
	}
	public Song()
	{
		this.songData1 = null;
		this.songData2 = null;
		this.songData3 = null;
		this.songData4 = null;
	}

	public I getSongData1() {
		return songData1;
	}



	public void setSongData1(I songData1) {
		this.songData1 = songData1;
	}



	public Y getSongData2() {
		return songData2;
	}



	public void setSongData2(Y songData2) {
		this.songData2 = songData2;
	}



	public T getSongData3() {
		return songData3;
	}



	public void setSongData3(T songData3) {
		this.songData3 = songData3;
	}



	public N getSongData4() {
		return songData4;
	}



	public void setSongData4(N songData4) {
		this.songData4 = songData4;
	}

	

	@Override
	public String toString() {
		return "Song Id = " + songData1 + ", Year Released = " + songData2 + ", Time in seconds = " + songData3 + ", Song Name = "
				+ songData4 ;
	}

	public static <E> void displayAllSongs(LinkedList<E>list)
	{
		for(E e: list)
		{
			System.out.println(e);
		}
	}
	public static void diaplayAllSongsArray(Song<Integer,Integer,Integer,String>[]a)
	{
		for(int i = 0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	public static Song<Integer,Integer,Integer,String>[] readSongs(Song<Integer,Integer,Integer,String>[] a) throws FileNotFoundException
	{
		Scanner input = new Scanner(reader);
		int count = 0;
		while(input.hasNext())
		{
			int songData1 = input.nextInt();
			int songData2 = input.nextInt();
			int songData3 = input.nextInt();
			String songData4 = input.nextLine();
			a[count] = new Song<Integer,Integer,Integer,String>(songData1, songData2, songData3, songData4);
			count++;
		}
		input.close();
		return a;
	}
	
	public static LinkedList<Song<Integer,Integer,Integer,String>> readSongs(LinkedList<Song<Integer,Integer,Integer,String>> list) throws FileNotFoundException
	{
		Scanner input = new Scanner(reader);
		while(input.hasNext())
		{
			int songData1 = input.nextInt();
			int songData2 = input.nextInt();
			int songData3 = input.nextInt();
			String songData4 = input.nextLine();
			list.add(new Song<Integer,Integer,Integer,String>(songData1, songData2, songData3, songData4));
					
		}
		input.close();
		return list;
	}
	
	public static Song<Integer,Integer,Integer,String> searchSongs(String n, Song<Integer, Integer, Integer, String> [] songs) throws FileNotFoundException
	{
		for(Song<Integer, Integer, Integer, String> e : songs)
		{
			if(e.getSongData4().compareTo(n) ==0)
			{
				return e;
			}
		}
				
		return null;
		
	}
	
	public static Song<Integer,Integer,Integer,String>searchSongs(int y, String n, LinkedList<Song<Integer,Integer,Integer,String>>l) throws FileNotFoundException
	{
		for(Song<Integer,Integer,Integer,String> e: l)
		{
			if(e.getSongData2().compareTo(y)==0 && e.getSongData4().compareTo(n) ==0)
			{
				return e;
			}
		}
		return null;
	}
	
	public static void songComparator(Song<Integer,Integer,Integer,String>[]a)
	{
		Arrays.sort(a,Comparator.comparing(Song<Integer,Integer,Integer,String>::getSongData4));
		for(Song<Integer,Integer,Integer,String>s : a)
		{
			System.out.println(s);
		}
	}
	
	public static void songComparator(List<Song<Integer,Integer,Integer,String>>l)
	{
		l.sort(Comparator.comparing(Song<Integer,Integer,Integer,String>::getSongData3).thenComparing(Song<Integer,Integer,Integer,String>::getSongData4));
		for(Song<Integer,Integer,Integer,String>s:l)
		{
			System.out.println(s);
		}
	}
	


	@SuppressWarnings({ "unchecked" })
	public static void main(String [] args) throws FileNotFoundException
	{
		//tests readDongs for a list of songs and prints them
		LinkedList<Song<Integer,Integer,Integer,String>> songs = new LinkedList<>();
		readSongs(songs);
		
		System.out.println("Song list:");
		displayAllSongs(songs);
		
		//tests readSongs for array of songs and prints them
		Song<Integer,Integer,Integer,String>[] songArray = new Song[25];
		readSongs(songArray);
		
		System.out.println("Array of Songs:");
		diaplayAllSongsArray(songArray);
		
		System.out.println();
		//Search by name in a list
		if(searchSongs(" \"Africa\"", songArray) != null)
		{
			System.out.println("Song with the name 'Afica' is : " + searchSongs(" \"Africa\"",songArray).getSongData4());
		}
		else
		{
			System.out.println("Song is not on the list");
		}
		System.out.println();
		//search by year then name
		if(searchSongs(1982, " \"Africa\"", songs)!= null)
		{
			System.out.println("Song released in 1982 with name 'Africa': " + searchSongs(1982, " \"Africa\"",songs).getSongData4());
		}
		else
		{
			System.out.println("Song is not on the list");
		}
		
		System.out.println();
		System.out.println("Comparing movies by name:");
		songComparator(songArray);
		
		System.out.println();
		System.out.println("Comparing movies by year then name:");
		songComparator(songs);
	}
	

}
