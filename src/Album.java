import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;

        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //find song
    boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    // add song to album
    String addSongToAlbum(String title, double duration){
        if(findSong(title) == false){
            Song s = new Song(title, duration);
            songs.add(s);
            return "Song added successfully to the album";
        }
        return "Song already exists";
    }

    //add song to playlist from album
    String addSongToPlaylistFromAlbum(String title, List<Song> playlist){
        if(findSong(title) == true){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    return "Song added to playlist";
                }
            }
        }
        return "Song not present in Album";
    }

    String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index = trackNo - 1;
        if(index >= 0 && index < this.songs.size()){
            playlist.add(this.songs.get(index));
            return "Song has been added to PlayList!";
        }

        return "Invalid Position of Song";
    }


}
