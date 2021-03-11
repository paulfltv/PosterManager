package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
	private PosterManager manager = new PosterManager(7);
	private MoviePoster first = new MoviePoster(
			1, 1, "Bloodshot", "action", 16, true);
	private MoviePoster second = new MoviePoster(
			2, 2, "Onward", "animated", 6, true);
	private MoviePoster third = new MoviePoster(
			3, 3, "Hotel 'Belgrade'", "comedy", 6, true);
	private MoviePoster fourth = new MoviePoster(
			4, 4, "The Gentlemen", "action", 18, true);
	private MoviePoster fifth = new MoviePoster(
			5, 5, "The Invisible Man", "horror", 18, true);
	private MoviePoster sixth = new MoviePoster(
			6, 6, "Trolls World Tour", "animated", 6, false);
	private MoviePoster seventh = new MoviePoster(
			7, 7, "Number One", "comedy", 12, false);

	@BeforeEach
	public void setUp() {
		manager.add(first);
		manager.add(second);
		manager.add(third);
		manager.add(fourth);
		manager.add(fifth);
		manager.add(sixth);
		manager.add(seventh);
	}

	@Test
	public void shouldRemoveMovieIfExists() {
		int idToRemove = 1;
		manager.removeById(idToRemove);
		MoviePoster[] actual = manager.getAll();
		MoviePoster[] expected = new MoviePoster[]{seventh, sixth, fifth, fourth, third, second};
		assertArrayEquals(expected, actual);
	}

	@Test
	@Disabled
	public void shouldNotRemoveIfNotExists() {
		int idToRemove = 4;
		manager.removeById(idToRemove);
		MoviePoster[] actual = manager.getAll();
		MoviePoster[] expected = new MoviePoster[]{seventh, sixth, fifth, fourth, third, second, first};
		assertArrayEquals(expected, actual);
	}
}