package assignment.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "players")
public class PlayerListWrapper {
	private List<Player> _players;

    @XmlElement(name = "player")
    public List<Player> getPersons() {
        return _players;
    }

    public void setPersons(List<Player> players) {
       _players=players;
    }
}
