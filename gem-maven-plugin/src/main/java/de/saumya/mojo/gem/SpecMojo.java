package de.saumya.mojo.gem;

import org.apache.maven.plugin.MojoExecutionException;

import de.saumya.mojo.jruby.AbstractJRubyMojo;

/**
 * goal to run "gem spec".
 *
 * @goal spec
 */
public class SpecMojo extends AbstractJRubyMojo {
    /**
     * arguments for the gem command of JRuby.
     *
     * @parameter default-value="${gem.spec}"
     */
    protected String args = null;

    public void execute() throws MojoExecutionException {
        String commandString = "-S gem spec";
        if (this.args != null) {
            commandString += " " + this.args;
        }
        execute(commandString, false);
    }
}
