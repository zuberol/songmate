package pl.jzuber.songmate.dao;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.repositories.ArtistRepository;

@Service
public class DataAccessObject {

//    ConnectionFactory connectionFactory;
//
//    @Autowired
//    public DataAccessObject(@Qualifier("psql") ConnectionFactory connectionFactory) {
//        this.connectionFactory = connectionFactory;
//    }

    @Autowired
    public ArtistRepository artistRepository;







}
