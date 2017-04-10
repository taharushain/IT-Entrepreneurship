single_quoted = 'Icecream \n followed by it\'s a party!'
double_quoted = "Icecream \n followed by it\'s a party!"


puts single_quoted
puts double_quoted

def multiply(one, two)
	"#{one} mutplied by #{two} is equals to #{one*two}"
end


puts multiply(2,2)

puts multiply(3,2)


def return_multiline_string
	%Q{
		I am a multiline string
		I am a multiline string
		I am a multiline string
	}
end

puts return_multiline_string