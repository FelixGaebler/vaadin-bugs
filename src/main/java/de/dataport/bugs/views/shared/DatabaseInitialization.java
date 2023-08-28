package de.dataport.bugs.views.shared;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitialization implements CommandLineRunner {

	private final DataRepository dataRepository;

	private final CollectionRepository collectionRepository;

	public DatabaseInitialization(DataRepository dataRepository, CollectionRepository collectionRepository) {
		this.dataRepository = dataRepository;
		this.collectionRepository = collectionRepository;
	}

	@Override
	public void run(String... args) {
		List<Data> dataList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Data data = new Data();
			data.setText("data-" + i);
			dataList.add(data);
		}

		this.dataRepository.saveAll(dataList);

		Collection collection = new Collection();
		collection.setList(dataList);

		this.collectionRepository.save(collection);
	}

}
