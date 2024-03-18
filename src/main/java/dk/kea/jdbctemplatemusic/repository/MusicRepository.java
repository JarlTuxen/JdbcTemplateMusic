package dk.kea.jdbctemplatemusic.repository;

import dk.kea.jdbctemplatemusic.model.MusicData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {
    public List<MusicData> getAll() {
        List<MusicData> albums = new ArrayList<>();

        albums.add(new MusicData("Metallica", "Master of Puppets", 1986, "Elektra"));
        albums.add(new MusicData("Black Sabbath", "Paranoid", 1970, "Vertigo"));
        albums.add(new MusicData("Iron Maiden", "The Number of the Beast", 1982, "EMI"));
        albums.add(new MusicData("Slayer", "Reign in Blood", 1986, "Def Jam"));
        albums.add(new MusicData("Megadeth", "Rust in Peace", 1990, "Capitol"));
        albums.add(new MusicData("Pantera", "Vulgar Display of Power", 1992, "Atco"));
        albums.add(new MusicData("Opeth", "Blackwater Park", 2001, "Music for Nations"));
        albums.add(new MusicData("Tool", "Lateralus", 2001, "Volcano"));
        albums.add(new MusicData("Mastodon", "Crack the Skye", 2009, "Reprise"));
        albums.add(new MusicData("Gojira", "From Mars to Sirius", 2005, "Listenable"));

        return albums;
    }
}
