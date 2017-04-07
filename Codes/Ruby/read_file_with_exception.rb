begin
	File.foreach('test123.txt') do |line|
		puts line
		p line
		p line.chomp
		p line.split
	end	
rescue Exception => e
	puts e.message
	puts "Working"
end

