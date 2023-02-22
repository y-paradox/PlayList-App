import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Melodies", "Sanam");
        album1.addSongToAlbum("Song 1", 5.3);
        album1.addSongToAlbum("Song 2", 4.5);
        album1.addSongToAlbum("Song 3", 3.5);

        Album album2 = new Album("Rocks", "Arijit Singh");
        album2.addSongToAlbum("Rock 1", 5.9);
        album2.addSongToAlbum("Rock 2", 3.7);
        album2.addSongToAlbum("Rock 3", 4.4);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("Rock 2", myPlaylist));
        System.out.println(album1.addSongToPlaylistFromAlbum(3, myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum(1, myPlaylist));

        play(myPlaylist);
    }

    public static void play(List<Song> playList){

        ListIterator<Song> itr = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("Playlist is Empty");
            return;
        }

        boolean isNext;


        System.out.println("Currently playing: ");
        System.out.println(itr.next());
        isNext = true;

        Scanner sc = new Scanner(System.in);

        printMenu();
        while(true){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice){

                case 1:  // next song
                    if(!isNext){
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                        isNext = true;
                    }
                    else{
                        System.out.println("Reached at the end of Playlist");
                    }
                    break;
                case 2:  // previous song
                    if(isNext){
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                        isNext = false;
                    }
                    else{
                        System.out.println("You are on first song already");
                    }
                    break;
                case 3:  // current song
                    if(isNext == true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isNext = true;
                        }
                    }
                    break;
                case 4:   // delete current song
                    if(isNext == true){
                        if(itr.hasPrevious()){
                            itr.remove();
                            itr.previous();
                            System.out.println("Song removed from playlist");
                            isNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            itr.remove();
                            itr.next();
                            System.out.println("Song removed from playlist");
                            isNext = true;
                        }
                    }
                    break;
                case 5:
                    printAllSongs(playList);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:  // exit
                    return;
            }
        }
    }

    static void printAllSongs(List<Song> playList){
        for(Song song: playList) {
            System.out.println(song);
        }
    }

    static void printMenu(){
        System.out.println("1. Play Next Song");
        System.out.println("2. Play Previous Song");
        System.out.println("3. Play Current Song Again");
        System.out.println("4. Delete Current Song");
        System.out.println("5. Show All Songs");
        System.out.println("6. Show Menu Again");
        System.out.println("7. Exit");
    }



}