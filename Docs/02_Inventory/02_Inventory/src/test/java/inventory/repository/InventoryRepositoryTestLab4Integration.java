package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import inventory.model.Part;
import inventory.model.Product;
import inventory.service.InventoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryRepositoryTestLab4Integration {

    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPart() {
        Part part = new InhousePart(1, "Test Part", 19.99, 5, 1, 10, 123);
        inventory.addPart(part);
        inventoryRepository = new InventoryRepository(inventory);
        Mockito.verify(inventory).addPart(part);
        ObservableList<Part> parts = FXCollections.observableArrayList(part);
        Mockito.when(inventoryService.getAllParts()).thenReturn(parts);
    }

    @Test
    public void testGetAllParts() {
        Part part = new InhousePart(1, "Test Part", 19.99, 5, 1, 10, 123);
        inventory.addPart(part);
        inventoryRepository = new InventoryRepository(inventory);
        Mockito.verify(inventory).addPart(part);
        ObservableList<Part> parts = FXCollections.observableArrayList(part);
        Mockito.when(inventoryService.getAllParts()).thenReturn(parts);
    }
}
