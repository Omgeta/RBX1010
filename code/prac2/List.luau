local List = {}
List.__index = List

-- Constructor: Initialize a node with data and a nil tail
function List.new(data)
	local self = setmetatable({}, List)
	self.data = data
	self.tail = nil
	return self
end

-- Add an element with value `x` to the end of the list
function List:append(x)
	local curr = self
	while curr.tail do
		curr = curr.tail
	end
	curr.tail = List.new(x)
end

-- Pop the last List and return its value
function List:pop()
	if not self.tail then
		return self.data
	end

	local curr = self
	while curr.tail and curr.tail.tail do
		curr = curr.tail
	end
	local value = curr.tail.data
	curr.tail = nil
	return value
end

-- Get the List at index `i`
function List:get(i: number)
	local curr = self
	local j = 1

	while j < i and curr.tail do
		curr = curr.tail
		j = j + 1
	end

	return j == i and curr or nil
end

-- Remove the List at index `i`
function List:remove(i: number)
	local prev = nil
	local curr = self
	local j = 1

	while j < i and curr.tail do
		prev = curr
		curr = curr.tail
		j = j + 1
	end

	if j == i then
		-- for non-head, we stitch the prev to the next tail
		-- for head removal edge case (undefined by qn),
		-- i choose to cut off the remaining list and let GC clean it up
		if prev then
			prev.tail = curr.tail
		end
		curr.tail = nil
		return curr
	end
	return nil
end

-- Get the length of the list
function List:length()
	local curr = self.tail
	local i = 1
	while curr do
		i = i + 1
		curr = curr.tail
	end
	return i
end

return List
