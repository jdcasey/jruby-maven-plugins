package de.saumya.mojo.rails;

import java.io.File;

import de.saumya.mojo.gem.AbstractGemMojo;

/**
 * abstract rails mojo which provides a few helper methods and the rails.args
 * parameter.
 */
public abstract class AbstractRailsMojo extends AbstractGemMojo {

    /**
     * @parameter expression="${args}"
     */
    protected String args;

    /**
     * @parameter expression="${rails.dir}"
     *            default-value="${project.basedir}/src/main/rails"
     */
    protected File   dir;

    /**
     * either development or test or production or whatever else is possible
     * with your config
     * 
     * @parameter expression="${rails.env}"
     */
    protected String env;

    @Override
    protected File launchDirectory() {
        if (this.dir.exists()) {
            return this.dir;
        }
        else {
            return super.launchDirectory();
        }
    }

    protected File binDirectory() {
        if (this.gemHome == null) {
            if (System.getenv("GEM_HOME") == null) {
                // TODO something better is needed I guess
                return null;
            }
            else {
                return new File(System.getenv("GEM_HOME"), "bin");
            }
        }
        else {
            return new File(this.gemHome, "bin");
        }
    }

    protected StringBuilder binScript(final String script) {
        return new StringBuilder(new File(binDirectory(), script).getAbsolutePath());
    }

    protected StringBuilder railsScript(final String command) {
        final StringBuilder builder = new StringBuilder("script/");
        builder.append(command);
        return builder;
    }
}
