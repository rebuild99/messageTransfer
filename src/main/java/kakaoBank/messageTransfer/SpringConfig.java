package kakaoBank.messageTransfer;

import kakaoBank.messageTransfer.dao.MessageTransferDaoImpl;
import kakaoBank.messageTransfer.dao.MessageTransferDao;
import kakaoBank.messageTransfer.service.MessageTransferSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource datasource) {
        this.dataSource = datasource;
    }

    @Bean
    public MessageTransferDao messageTransferDao() {
        return new MessageTransferDaoImpl(dataSource);
    }

    @Bean
    public MessageTransferSvc messageTransferSvc() {
        return new MessageTransferSvc(messageTransferDao());
    }
}
