package dk.kea.jdbctemplatemusic.repository;

import dk.kea.jdbctemplatemusic.model.MusicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MusicData> findAll(){
        final String GET_ALL_SQL = "SELECT * FROM albums ORDER BY year";
        return jdbcTemplate.query(GET_ALL_SQL, new BeanPropertyRowMapper<>(MusicData.class));

    }

    public void insert(MusicData musicData){
        final String INSERT_SQL = "INSERT INTO albums (artist, year, company, title) VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(INSERT_SQL, musicData.getArtist(), musicData.getYear(), musicData.getCompany(), musicData.getCompany());
    }

    public MusicData findById(int id){
        final String FIND_BY_ID_SQL = "SELECT * FROM albums WHERE id = ?;";
        RowMapper<MusicData> rowMapper = new BeanPropertyRowMapper<>(MusicData.class);
        return jdbcTemplate.queryForObject(FIND_BY_ID_SQL, rowMapper, id);
    }

    public void deleteById(int id){
        final String DELETE_BY_ID = "DELETE FROM albums WHERE id = ?;";
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    public void update(MusicData musicData){
        final String UPDATE_SQL = "UPDATE albums SET artist = ?, year = ?, company = ?, title = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_SQL, musicData.getArtist(), musicData.getYear(), musicData.getCompany(), musicData.getTitle(), musicData.getIdalbum());
    }

    public List<MusicData> getAllStatic() {
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

    public Integer avgYear(){
        final String sql = "SELECT AVG(year) FROM albums";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    public Integer minYear(){
        final String sql = "SELECT MIN(year) FROM albums";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    public Integer maxYear(){
        final String sql = "SELECT MAX(year) FROM albums";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

}
