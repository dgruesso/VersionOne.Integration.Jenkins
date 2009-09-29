package com.versionone.hudsonnotifier;

/**
 * Sample {@link hudson.tasks.Builder}.
 *
 * <p>
 * When the user configures the project and enables this builder,
 * {@link DescriptorImpl#newInstance(org.kohsuke.stapler.StaplerRequest)} is invoked
 * and a new {@link backup_HelloWorldBuilder} is created. The created
 * instance is persisted to the project configuration XML by using
 * XStream, so this allows you to use instance fields (like {@link #name})
 * to remember the configuration.
 *
 * <p>
 * When a build is performed, the {@link #perform(hudson.model.Build, hudson.Launcher, hudson.model.BuildListener)} method
 * will be invoked.
 *
 * @author Kohsuke Kawaguchi
 */
//
//public class backup_HelloWorldBuilder extends Builder {
//
//    private final String name;
//
//    @DataBoundConstructor
//    public backup_HelloWorldBuilder(String name) {
//        this.name = name;
//    }
//
//    /**
//     * We'll use this from the <tt>config.jelly</tt>.
//     */
//    public String getName() {
//        return name;
//    }
//
//    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
//        // this is where you 'build' the project
//        // since this is a dummy, we just say 'hello world' and call that a build
//
//        // this also shows how you can consult the global configuration of the builder
//        if(getDescriptor().useFrench())
//            listener.getLogger().println("Bonjour, "+name+"!");
//        else
//            listener.getLogger().println("Hello, "+name+"! Jast added text!");
//        return true;
//    }
//
//    // overrided for better type safety.
//    // if your plugin doesn't really define any property on Descriptor,
//    // you don't have to do this.
//    public DescriptorImpl getDescriptor() {
//        return (DescriptorImpl)super.getDescriptor();
//    }
//
//    /**
//     * Descriptor for {@link backup_HelloWorldBuilder}. Used as a singleton.
//     * The class is marked as public so that it can be accessed from views.
//     *
//     * <p>
//     * See <tt>views/hudson/plugins/hello_world/HelloWorldNotifier/*.jelly</tt>
//     * for the actual HTML fragment for the configuration screen.
//     */
//    @Extension // this marker indicates Hudson that this is an implementation of an extension point.
//    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {
//        /**
//         * To persist global configuration information,
//         * simply store it in a field and call save().
//         *
//         * <p>
//         * If you don't want fields to be persisted, use <tt>transient</tt>.
//         */
//        private boolean useFrench;
//
//        /**
//         * Performs on-the-fly validation of the form field 'name'.
//         *
//         * @param value
//         *      This parameter receives the value that the user has typed.
//         * @return
//         *      Indicates the outcome of the validation. This is sent to the browser.
//         */
//        public FormValidation doCheckName(@QueryParameter String value) throws IOException, ServletException {
//            if(value.length()==0)
//                return FormValidation.error("Please set a name");
//            if(value.length()<4)
//                return FormValidation.warning("Isn't the name too short?");
//            return FormValidation.ok();
//        }
//
//        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
//            // indicates that this builder can be used with all kinds of project types
//            return true;
//        }
//
//        /**
//         * This human readable name is used in the configuration screen.
//         */
//        public String getDisplayName() {
//            return "Say hello world";
//        }
//
//        public boolean configure(StaplerRequest req, JSONObject o) throws FormException {
//            // to persist global configuration information,
//            // set that to properties and call save().
//            useFrench = o.getBoolean("useFrench");
//            save();
//            return super.configure(req,o);
//        }
//
//        /**
//         * This method returns true if the global configuration says we should speak French.
//         */
//        public boolean useFrench() {
//            return useFrench;
//        }
//    }
//}