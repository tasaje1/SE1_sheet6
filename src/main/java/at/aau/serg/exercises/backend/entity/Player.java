package at.aau.serg.exercises.backend.entity;

import at.aau.serg.exercises.backend.dao.EntityWithId;

import java.util.Objects;

public class Player extends EntityWithId<Long> {
	private Long id;
	private String username;
	private String email;

	public Player() {
	}

	public Player(Long id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Player)) return false;
		Player player = (Player) o;
		return Objects.equals(id, player.id) && Objects.equals(username, player.username) && Objects.equals(email, player.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, email);
	}

	@Override
	public String toString() {
		return "Player{" +
				"id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
