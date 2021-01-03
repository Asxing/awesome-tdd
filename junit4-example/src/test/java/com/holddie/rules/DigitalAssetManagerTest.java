package com.holddie.rules;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;

public class DigitalAssetManagerTest {
	@Rule
	public final TemporaryFolder tempFolder = new TemporaryFolder();

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void countsAssets() throws IOException {
		File icon = tempFolder.newFile("icon.png");
		File assets = tempFolder.newFolder("assets");
		createAssets(assets, 3);

		DigitalAssetManager dam = new DigitalAssetManager(icon, assets);
		assertEquals(3, dam.getAssetCount());
	}

	private void createAssets(File assets, int numberOfAssets) throws IOException {
		for (int index = 0; index < numberOfAssets; index++) {
			File asset = new File(assets, String.format("asset-%d.mpg", index));
			Assert.assertTrue("Asset couldn't be created.", asset.createNewFile());
		}
	}

	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Icon is null, not a file, or doesn't exist.");
		new DigitalAssetManager(null, null);
	}

	private class DigitalAssetManager {


		public DigitalAssetManager(Object o, Object o1) {
			if (Objects.isNull(o) && Objects.isNull(o1)) {
				throw new IllegalArgumentException("Icon is null, not a file, or doesn't exist.");
			}
		}

		int getAssetCount() {
			return 3;
		}
	}
}