package com.ericsson.mstv.plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Maven_3_jdk_7:
 *   image: maven:3-jdk-7
 *   working_dir: /app
 *   command: mvn compile
 *   external_links:
 *     - artifactory
 * Maven_3_jdk_8:
 *   image: maven:3-jdk-8
 *   working_dir: /app
 *   command: mvn compile
 *   external_links:
 *     - artifactory
 */

/**
 * Goal which counts lines of code of a project
 * 
 * @goal build
 * @phase compile
 * 
 */
public class BuildImage extends AbstractMojo {

	private static final String PATH = "/root";
	private static final String FILE = "docker-compose.yml";

	/**
	 * @parameter expression = "${buildimages}" default-value="maven:3-jdk-7"
	 */
	private String image;

	/**
	 * @parameter expression = "${working_dir}" default-value="/app"
	 */
	private String working_dir;

	/**
	 * @parameter expression = "${command}" default-value="mvn compile"
	 */
	private String command;

	public void execute() throws MojoExecutionException, MojoFailureException {
		// TODO Auto-generated method stub
		String file = PATH + File.separator + FILE;
		File f = new File(file);
		if (f.exists()) {
			f.exists();
		}

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, false);
			bw = new BufferedWriter(fw);
			for (String _image : image.split(",")) {
				writeToFile(bw, genContent(_image, working_dir));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String[] genContent(String _image, String wd) {
		String[] lines = { _image.replace(":", "_"), "\timage: " + _image,
				"\tworking_dir: " + wd, "\tcommand: " + "mvn compile",
				"\texternal_links: ", "\t\t- artifactory" };
		return lines;
	}

	private void writeToFile(BufferedWriter bw, String[] lines)
			throws IOException {
		for (String line : lines) {
			bw.write(line + "\n");
		}
		bw.flush();
	}

}
