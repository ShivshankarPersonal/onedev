import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	private static final Logger logger = LoggerFactory.getLogger(DiffCommand.class);
	private String revisions;
	public DiffCommand revisions(String revisions) {
		this.revisions = revisions;
		Preconditions.checkNotNull(revisions, "revisions has to be specified.");
		cmd.addArgs("diff", revisions, "--full-index", "--no-color", "--find-renames", 
				"--find-copies", "--src-prefix=#gitplex_old/", "--dst-prefix=#gitplex_new/");
					line = line.substring("diff --git #gitplex_old/".length());
					changeBuilder.oldPath = StringUtils.substringBefore(line, " #gitplex_new/");
					changeBuilder.newPath = StringUtils.substringAfter(line, " #gitplex_new/");
					logger.warn(line.substring("warning: ".length()));
					logger.warn(line);
					logger.warn(line);
					logger.error(line);