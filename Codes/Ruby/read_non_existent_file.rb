File.foreach('does_not_exists.txt') do |line|
	puts line
	p line
	p line.chomp
	p line.split
end