import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
