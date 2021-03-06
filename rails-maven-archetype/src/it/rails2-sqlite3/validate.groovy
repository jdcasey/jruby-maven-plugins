success1 = false
success2 = false
success3 = false
new File(basedir, 'target/Gemfile.maven').eachLine{ 
  success1 = success1 || (it =~ '^\\s*gem .sqlite3-ruby.')
  success2 = success2 || (it =~ '^\\s*gem "activerecord-jdbc-adapter"')
  success3 = success3 || (it =~ '^\\s*gem "jdbc-sqlite3"')
  // println "read the following line -> " + it + " " + success1 + success2 + success3
}

success_jdbc = false
success_version = false
new File(basedir, 'target/pom.xml').eachLine{ 
  success_jdbc = success_jdbc || (it =~ '<artifactId>jdbc-sqlite3</artifactId>')
  success_version = success_version || (it =~ '<version>2.3.5</version>')
}

success_index = false
new File(basedir, 'target/index.html').eachLine{ 
  success_index = success_index || (it =~ '<code>mvn rails2:help</code> ')
}
success_users = false
new File(basedir, 'target/users.html').eachLine{ 
  success_users = success_users || (it =~ '<h1>Listing users</h1>')
}
success_new = false
new File(basedir, 'target/new.html').eachLine{ 
  success_new = success_new || (it =~ 'value="Create"')
}


assert success1
assert success2
assert success3
assert success_jdbc
assert success_version
assert success_index
assert success_users
assert success_new
