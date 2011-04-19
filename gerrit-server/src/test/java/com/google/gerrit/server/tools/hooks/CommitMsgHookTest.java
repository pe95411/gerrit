import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.ObjectInserter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
  @Rule public TestName test = new TestName();
  private void skipIfWin32Platform() {
    if (HostPlatform.isWin32()) {
      System.err.println(" - Skipping " + test.getMethodName() + " on this system");
      assumeTrue(false);
    }
  @Before
  public void setUp() throws Exception {
    skipIfWin32Platform();
  @Test
  @Test
  @Test
  @Test
  @Test
    final DirCacheBuilder builder = repository.lockDirCache().builder();
  @Test
  @Test
  @Test
  @Test
  @Test
  @Test
  @Test
  @Test
  @Test
    final ObjectInserter oi = repository.newObjectInserter();
    try {
      final DirCacheEntry e = new DirCacheEntry(name);
      e.setFileMode(FileMode.REGULAR_FILE);
      e.setObjectId(oi.insert(Constants.OBJ_BLOB, Constants.encode(name)));
      oi.flush();
      return e;
    } finally {
      oi.release();
    }
    final ObjectInserter oi = repository.newObjectInserter();
    try {
      final CommitBuilder commit = new CommitBuilder();
      commit.setTreeId(oi.insert(Constants.OBJ_TREE, new byte[] {}));
      commit.setAuthor(author);
      commit.setCommitter(committer);
      commit.setMessage("test\n");
      ObjectId commitId = oi.insert(commit);

      final RefUpdate ref = repository.updateRef(Constants.HEAD);
      ref.setNewObjectId(commitId);
      switch (ref.forceUpdate()) {
        case NEW:
        case FAST_FORWARD:
        case FORCED:
        case NO_CHANGE:
          break;
        default:
          fail(Constants.HEAD + " did not change: " + ref.getResult());
      }
    } finally {
      oi.release();